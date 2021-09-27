import java.text.DecimalFormat;
import java.util.*;
public class U4AIE20144_DSA2_assign2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String [] enterline;
        AVLTree ob = new AVLTree();
        int testcase = in.nextInt();
        in.nextLine();

        for(int i=1; i<=testcase;i++)
        {
            String line=in.nextLine();
            String SPACE=" ";
            enterline=line.split(SPACE);
            int [] numb= new int [enterline.length];
            
            if(enterline[0].startsWith("A")|| enterline[0].startsWith("R"))
            {
                for(int j=1;j<enterline.length;j++)
                {
                    int numbers=Integer.parseInt(enterline[j]);
                    numb[j]=numbers;
                }
                if("A".equals(enterline[0]))
                {
                    for(int j=1;j<=enterline.length-1;j++)
                    {
                        ob.root= ob.insert(ob.root,numb[j]);
                    }
                }
                else if("R".equals(enterline[0]))
                {
                    for(int j=1;j<=enterline.length-1;j++)
                    {
                        ob.root= ob.Remove(ob.root,numb[j]);
                    }
                }
            }
            else
            {
                for(int j=0;j<enterline.length;j++)
                {
                    int numbers=Integer.parseInt(enterline[j]);
                    numb[j]=numbers;
                    try
                    {
                        AVLNode eNode = ob.search(ob.root,numb[j]);
                        int height=ob.Hei(eNode);
                        int min =ob.min(eNode);
                        int max=ob.max(eNode);
                        ob.Average(eNode);
                        System.out.print(height+1+" ");
                        System.out.print(min+" ");
                        System.out.print(max+" ");
                        DecimalFormat avg = new DecimalFormat("#.#");
                        System.out.print(avg.format(ob.sumelem/ob.count));
                        ob.sumelem=0;
                        ob.count=0;
                        System.out.println();
                    }
                    catch(Exception a)
                    {
                        System.out.println("-1");
                    }
                }
                
            }
        }
    }
} 
class AVLTree
{
    AVLNode root;
    AVLNode left;
    AVLNode right;
    double count=0;
    double sumelem=0;
    AVLNode insert(AVLNode node, int key) 
    {
        if (node == null)
        {
            return (new AVLNode(key));
        }
        if (key < node.data)
        {
            node.left = insert(node.left, key);
        }
        else if (key > node.data)
        {
            node.right = insert(node.right, key);
        }
        else // to avoid duplication
        {
            return node;
        }
            
        node.balancefactor = 1 + max(height(node.left),height(node.right));
     
        int balance = ComputeBalance(node);

        if (balance > 1 && key < node.left.data)
        {
            return RotateRightChild(node);
        }
        if (balance < -1 && key > node.right.data)
        {
            return RotateLeftChild(node);
        }
        if (balance > 1 && key > node.left.data) 
        {
            node.left = RotateLeftChild(node.left);
            return RotateRightChild(node);
        }
        if (balance < -1 && key < node.right.data) 
        {
            node.right = RotateRightChild(node.right);
            return RotateLeftChild(node);
        }
        return node;
    }
    AVLNode Remove(AVLNode root, int key)
    {
        if (root == null)
        {
            return root;
        }
        if (key < root.data)
        {
            root.left = Remove(root.left, key);
        }
        else if (key > root.data)
        {
            root.right = Remove(root.right, key);
        }
        else
        {
            // node with only one child or no child
            if ((root.left == null) || (root.right == null))
            {
                AVLNode temp = null;
                if (temp == root.left)
                {
                    temp = root.right;
                }
                else
                {
                    temp = root.left;
                }
 
                // when there is no child
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else // One child case
                {
                    root = temp; 
                }
            }
            else
            {
                AVLNode temp = minValueNode(root.right);
                root.data = temp.data;
                root.right = Remove(root.right, temp.data);
            }
        }
        if (root == null)
        {
            return root;
        }
        root.balancefactor = max(height(root.left), height(root.right)) + 1;

        int balance = ComputeBalance(root);
        if (balance > 1 && ComputeBalance(root.left) >= 0)
        {
            return RotateRightChild(root);
        }
        if (balance > 1 && ComputeBalance(root.left) < 0)
        {
            root.left = RotateLeftChild(root.left);
            return RotateRightChild(root);
        }
        if (balance < -1 && ComputeBalance(root.right) <= 0)
        {
            return RotateLeftChild(root);
        }
        if (balance < -1 && ComputeBalance(root.right) > 0)
        {
            root.right = RotateRightChild(root.right);
            return RotateLeftChild(root);
        }
        return root;
    }
    AVLNode search(AVLNode node, int key)
    {  
        if (node.data == key)
        {
            return node;
        }
        if (key < node.data)
        {
            node = search(node.left, key);
        }
        else if (key > node.data)
        {
            node = search(node.right, key);
        }
        else
        {
            node=null;
        }
        return node;
    }
    void Average(AVLNode node) 
    {
		if (node != null) 
        {
			sumelem+=node.data;
			count++;
			Average(node.left);
			Average(node.right);
		}
	}
    int max(AVLNode root)
    {
        if(root==null)
        {
            return 0;
        }
        else
        {
            if(root.right==null)
            {
                return root.data;
            }
            else
            {
                return max(root.right);
            }
        }
    }
    int min(AVLNode root)
    {
        if(root==null)
        {
            return 0;
        }
        else
        {
            if(root.left==null)
            {
                return root.data;
            }
            else
            {
                return min(root.left);
            }
        }
    }
    AVLNode RotateRightChild(AVLNode rc) 
    {
        AVLNode lc = rc.left;
        AVLNode T2 = lc.right;
     
        lc.right = rc;
        rc.left = T2;
     
        rc.balancefactor = max(height(rc.left), height(rc.right)) + 1;
        lc.balancefactor = max(height(lc.left), height(lc.right)) + 1;
     
        return lc;
    }
    AVLNode RotateLeftChild(AVLNode lc) 
    {
        AVLNode rc = lc.right;
        AVLNode T2 = rc.left;
        
         rc.left = lc;
        lc.right = T2;
     
        lc.balancefactor = max(height(lc.left), height(lc.right)) + 1;
        rc.balancefactor = max(height(rc.left), height(rc.right)) + 1;
     
        return rc;
    }
    int ComputeBalance(AVLNode N) 
    {
        if (N == null)
        {
            return 0;
        }
        return height(N.left) - height(N.right);
    }         
    int height(AVLNode N) 
    {
        if (N == null)
        {
            return 0;
        }
        return N.balancefactor;
    }
    int max(int a, int b) 
    {
        return (a > b) ? a : b;
    }
    AVLNode minValueNode(AVLNode root)
    {
        AVLNode CN = root;
 
        while (CN.left != null)
        {
            CN = CN.left;
        }
        return CN;
    }
    int Hei(AVLNode node)
    {
        if(node==null)
        {
            return 0;
        }
        else
        {
            return node.height(node);
        }
    }
}
class AVLNode
{
    int data;
    AVLNode left;
    AVLNode right;
    int balancefactor;
    Vector<AVLNode> children;
    public AVLNode(int d)
    {
        data=d;
        balancefactor=1;
    }
    public int height(AVLNode root)
    {
        if(left==null && right ==null)
        {
            return 0;
        }
        else if(left!=null && right==null)
        {
            return left.height(root)+1;
        }
        else if(right!=null && left==null)
        {
            return right.height(root)+1;
        }
        else 
        {
            return max(left.height(root),right.height(root))+1;
        }
    }
    int max(int a, int b) 
    {
        return (a > b) ? a : b;
    }
}
