def generateGrayCode(n,bit=0,s=''):

    if n == 1:
        print(s + str(bit))
        bit = 0 if bit ==1 else 1
        print(s + str(bit)) 
        return; 
    
    generateGrayCode(n-1,0,s+str(bit))
    bit = 0 if bit ==1 else 1
    generateGrayCode(n-1,1,s+str(bit))

generateGrayCode(4)