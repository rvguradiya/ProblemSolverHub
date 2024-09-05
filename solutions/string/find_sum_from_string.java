class FindSum {
    public static void main(String[] args) {
        String str="03Ju23st 15te5ll10 12me6 3the ti45me 09f567or 06bu7s 23";
        int num=0;
        int sum=0;
        String numStr="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                numStr+=str.charAt(i);
            }else{
                if(numStr.length()>0){
                num=Integer.parseInt(numStr);
                sum=sum+num;
                }
                numStr="";
            }
        }
        if(numStr.length()>0)
        {
            num=Integer.parseInt(numStr);
            sum=sum+num;
        }
        System.out.println(sum);
    }
}
