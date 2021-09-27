t=int(input())
for i in range (1,t+1):
    array=input()
    arr=array.split()
    
    a=int(arr[0])
    b=int(arr[1])
    c=int(arr[2])
    
    sum=int(a+b+c)

    if(sum%9==0 and a>(sum/7)-1 and b>(sum/7)-1 and c>(sum/7)-1):
        print("1")
    elif (sum%9==0 and a<(sum/7)-1 and b<(sum/7)-1 and c<(sum/7)-1):
        print("0")
    elif(a==0 or b==0 or c==0):
        print("0")
    else:
        print("0")
        
