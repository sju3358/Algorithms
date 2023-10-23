    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.List;
    import java.util.TreeSet;

    class Solution {


        private static class Building{

            int x;
            int y;
            int type;

            public Building(int x, int y, int type){
                this.x = x;
                this.y = y;
                this.type = type;
            }


            public int[] toIntArray(){
                int[] array = new int[3];
                array[0] = x;
                array[1] = y;
                array[2] = type;

                return array;
            }

            @Override
            public boolean equals(Object o) {
                Building building = (Building)o;

                if(this.x != building.x)
                    return false;

                if(this.y != building.y)
                    return false;

                if(this.type != building.type)
                    return false;

                return true;
            }


        }

        private static class BuildingList{

            private ArrayList<Building> buildingList;

            public int size(){
                return this.buildingList.size();
            }

            public List<Building> getBuildingListOrdered(){
                this.buildingList.sort((o1, o2) ->{
                    if(o1.x != o2.x)
                        return o1.x - o2.x;
                    else if(o1.y != o2.y)
                        return o1.y - o2.y;
                    else
                        return o1.type - o2.type;
                });

                return buildingList;
            }

            public void add(int x, int y, int type){

                if(this.canSustain(x,y,type) == false)
                    return;

                this.buildingList.add(new Building(x,y,type));
            }

            public void remove(int x, int y, int type){

                this.buildingList.remove(new Building(x,y,type));

                if( this.canSustain() == false )
                    this.buildingList.add(new Building(x,y,type));
            }

            private boolean canSustain(){
                for(int i = 0; i < buildingList.size(); i++){
                    Building building = this.buildingList.get(i);
                    if(this.canSustain(building.x, building.y,building.type) == false)
                        return false;
                }
                return true;
            }

            private boolean canSustain(int x, int y, int type){

                Building building = new Building(x,y,type);

                switch (type){
                  case 0:
                      //바닥에 있을때
                      if( y== 0)
                          return true;

                      //또다른 기둥 위에 있을때
                      if( this.buildingList.contains(new Building(x,y-1,0)) )
                          return true;

                      //보의 한쪽 끝에 있을때
                      if( this.buildingList.contains(new Building(x,y,1)) || this.buildingList.contains(new Building(x-1,y,1) ))
                          return true;

                      return false;

                  case 1:

                      //한쪽 끝에 기둥이 있을때
                      if( this.buildingList.contains(new Building(x,y-1,0)) || this.buildingList.contains(new Building(x+1,y-1,0) ))
                          return true;

                      //양쪽 끝에 보가 있을때
                      if(this.buildingList.contains(new Building(x-1,y,1)) && this.buildingList.contains(new Building(x+1,y,1)))
                          return true;

                      return false;
              }

              return false;
            }


            public BuildingList(){
                this.buildingList = new ArrayList();
            }
        }


        public int[][] solution(int n, int[][] build_frame) {

            BuildingList buildingList = new BuildingList();

            for(int i = 0; i < build_frame.length; i++){
                int x = build_frame[i][0];
                int y = build_frame[i][1];
                int type = build_frame[i][2];
                int func = build_frame[i][3];

                switch (func){
                    case 0:
                        buildingList.remove(x,y,type);
                        break;
                    case 1:
                        buildingList.add(x,y,type);
                        break;
                }
            }



            int[][] answer = new int[buildingList.size()][3];
            List<Building> buildingListOrdered = buildingList.getBuildingListOrdered();
            for(int i = 0; i < buildingListOrdered.size(); i++){
                answer[i] = buildingListOrdered.get(i).toIntArray();
            }

            return answer;
        }

        public static void main(String args[]){
            // new Solution().solution(5, new int[][]{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}});
            new Solution().solution(5, new int[][]{{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}});
        }


    }