import java.util.ArrayList;


class Solution {

    private Set<ArrayList<Integer>> candidateKeys = new Set<>();

    private class Tuple {

        private String[] values;

        public Tuple(String[] values) {
            this.values = values;
        }

        public int getSizeOfValues(){
            return this.values.length;
        }
        public String getValueOf(int i) {
            return this.values[i];
        }

        @Override
        public boolean equals(Object obj) {

            Tuple target = (Tuple)obj;

            if (target.getSizeOfValues() != this.getSizeOfValues())
                return false;

            for (int i = 0; i < this.values.length; i++)
                if (this.getValueOf(i).equals(target.getValueOf(i)) == false)
                    return false;
            return true;
        }

    }
    private class Set<T>{
        private ArrayList<T> elements;

        public Set(){
            this.elements = new ArrayList<>();
        }

        public int size(){
            return this.elements.size();
        }
        public void add(T data){
            for(int i = 0; i < elements.size(); i++)
                if(elements.get(i).equals(data) == true)
                    return;
            elements.add(data);
        }

        public boolean contain(T data){
            for(int i = 0; i < elements.size(); i++)
                if(elements.get(i).equals(data) == true)
                    return true;
            return false;
        }
    }

    private boolean isElementOfSet(int set, int index){
        if((set & 1 << index) != 0)
            return true;
        else
            return false;
    }

    private ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> elements){

        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();

        for(int setBit = 1; setBit <= Math.pow(2,elements.size()); setBit++){

            ArrayList<Integer> set = new ArrayList<>();

            for(int index = 0; index < elements.size(); index++){

                if(isElementOfSet(setBit, elements.get(index)))
                    set.add(elements.get(index));

            }
            if(set.size() > 0)
                powerSet.add(set);
        }

        return powerSet;
    }

    private boolean isCandidateKey(ArrayList<Integer> columns, String[][] relation){

        Set<Tuple> tuples = new Set<>();

        for(int i = 0; i < relation.length; i++){
            String[] values = new String[columns.size()];

            for(int j = 0; j < columns.size(); j++)
                values[j] = relation[i][columns.get(j)];

            tuples.add(new Tuple(values));
        }

        if(tuples.size() == relation.length)
            return true;
        else
            return false;
    }

    private boolean isContainSubsetOfCandidateKey(ArrayList<ArrayList<Integer>> powerSetOfKey){
        for(ArrayList<Integer> subSetOfKey : powerSetOfKey)
            if(candidateKeys.contain(subSetOfKey))
                return true;
        return false;
    }
    private void findCandidateKey(String[][] relation){

        ArrayList<Integer> targetColumns = new ArrayList<>();
        for(int i = 0; i < relation[0].length; i++)
            targetColumns.add(i);

        ArrayList<ArrayList<Integer>> powerSet = getPowerSet(targetColumns);

        for(int i = 0; i < powerSet.size(); i++){

            ArrayList<Integer> set = powerSet.get(i);

            if(isCandidateKey(set,relation) == true){

                ArrayList<ArrayList<Integer>> powerSetOfKey = getPowerSet(set);

                if(isContainSubsetOfCandidateKey(powerSetOfKey) != true)
                    candidateKeys.add(set);
            }

        }

    }

    public int solution(String[][] relation) {

        findCandidateKey(relation);

        return candidateKeys.size();
    }

    public static void main(String args[]){
        System.out.println(new Solution().solution(
            new String[][]{
                {"100", "ryan", "music", "2"}
                , {"200", "apeach", "math", "2"}
                , {"300", "tube", "computer", "3"}
                , {"400", "con", "computer", "4"}
                , {"500", "muzi", "music", "3"}
                , {"600", "apeach", "music", "2"}
            }
        ));
        System.out.println(new Solution().solution(
            new String[][] {
                {"a","1","aaa","c","ng"},
                {"b","1","bbb","c","g"},
                {"c","1","aaa","d","ng"},
                {"d","1","bbb","d","ng"}
            }
        ));
    }



}