import java.util.ArrayList;
import java.util.Comparator;

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

    private ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> elements){

        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();

        for(int setBit = 1; setBit < (int)Math.pow(2,elements.size()); setBit++){

            ArrayList<Integer> subSet = new ArrayList<>();

            for(int index = 0; index < elements.size(); index++){

                if((setBit & (1 << index)) != 0){
                    subSet.add(elements.get(index));
                }
            }
            powerSet.add(subSet);
        }

        powerSet.sort((o1,o2) -> {return o1.size() - o2.size();});
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

    private boolean isContainSubsetOfCandidateKey(ArrayList<ArrayList<Integer>> powerSetOfCandidateKey){

        for(ArrayList<Integer> subSetOfCandidateKey : powerSetOfCandidateKey)
            if (candidateKeys.contain(subSetOfCandidateKey))
                return true;
        return false;
    }
    private void findCandidateKey(String[][] relation){

        ArrayList<Integer> targetColumns = new ArrayList<>();
        for(int i = 0; i < relation[0].length; i++)
            targetColumns.add(i);

        ArrayList<ArrayList<Integer>> powerSetOfRelation = getPowerSet(targetColumns);

        for(int i = 0; i < powerSetOfRelation.size(); i++){

            ArrayList<Integer> candidateKey = powerSetOfRelation.get(i);

            if(isCandidateKey(candidateKey,relation) == true){

                if(isContainSubsetOfCandidateKey(getPowerSet(candidateKey)) != true)
                    candidateKeys.add(candidateKey);
            }

        }

    }

    public int solution(String[][] relation) {

        findCandidateKey(relation);

        return candidateKeys.size();
    }

}