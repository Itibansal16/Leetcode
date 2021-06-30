class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList();
        for(int i = 0; i < searchWord.length(); i++){
            String prefix = searchWord.substring(0, i+1);
            List<String> current = new ArrayList();
            for(String product : products){
                if(product.startsWith(prefix)){
                    current.add(product);
                    if(current.size() == 3) break;
                }
            }
            ans.add(current);
        }
        return ans;
    }
}