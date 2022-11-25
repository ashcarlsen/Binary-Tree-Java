import java.util.Scanner;

public class BinaryTree {
    public Node root;
    BinaryTree()
    {}
    public static void main(String[] args)
    {
        BinaryTree myTree = new BinaryTree();
        int number;
        char operator;
        boolean loop = true;
        System.out.println("Welcome!");
        Scanner myScanner = new Scanner(System.in);
        while(loop)
        {
            System.out.println("Enter a to add or d to delete an item from the tree followed by a number.");
            operator = myScanner.next().charAt(0);
            if(operator != 'a' && operator != 'd')
            {
                System.out.println("Invalid operator: " + operator);
                loop = false;
            }
            number = myScanner.nextInt();
            if (operator == 'a')
            {
                myTree.addNode(number);
            }
            else if (operator == 'd')
            {
                myTree.deleteNode(number);
            }
        }
        myTree.printTree();
    }
    public void addNode(int v)
    {
        Node n = new Node(v);
        if(root == null)
        {
            root = n;
        }
        else
        {
            Node current = root;
            while(current != null)
            {
                if(v < current.value && current.left == null)
                {
                    current.left = n;
                    current = null;
                }
                else if(v < current.value)
                {
                    current = current.left;
                }
                else if(v > current.value && current.right == null)
                {
                    current.right = n;
                    current = null;
                }
                else if(v > current.value)
                {
                    current = current.right;
                }
                else
                {
                    current = null;
                }
            }
        }
    }

    public void deleteNode(int v)
    {
        if(this.root == null)
        {
            return;
        }
        Node current = this.root;
        Node previous = null;
        while(current.value != v)
        {
            if(v < current.value)
            {
                previous = current;
                current = current.left;
            }
            else
            {
                previous = current;
                current = current.right;
            }
            if(current == null)
            {
                return;
            }
        }
        if(current == root)
        {
            if(current.left == null && current.right == null)
            {
                root = null;
            }
            else if(current.left == null)
            {
                root = current.right;
            }
            else if(current.right == null)
            {
                root = current.left;
            }
            else
            {
                Node finder, prevfinder;
                finder = current.left;
                prevfinder = current;
                while(finder.right != null)
                {
                    prevfinder = finder;
                    finder = finder.right;
                }
                current.value = finder.value;
                if(finder.left != null)
                {
                    prevfinder.right = finder.left;
                }
                else
                {
                    prevfinder.right = null;
                }
            }
        }
        else if(current.left == null && current.right == null)
        {
            if(current.value < previous.value)
            {
                previous.left = null;
            }
            else
            {
                previous.right = null;
            }
        }
        else if(current.left == null & current.right != null)
        {
            if(current.value < previous.value)
            {
                previous.left = current.right;
            }
            else
            {
                previous.right = current.right;
            }
        }
        else if(current.left != null && current.right == null)
        {
            if(current.value < previous.value)
            {
                previous.left = current.left;
            }
            else
            {
                previous.right = current.left;
            }
        }
        else
        {
            Node finder, prevfinder;
            finder = current.left;
            prevfinder = current;
            while(finder.right != null)
            {
                prevfinder = finder;
                finder = finder.right;
            }
            current.value = finder.value;
            if(finder.left != null)
            {
                prevfinder.right = finder.left;
            }
            else
            {
                prevfinder.right = null;
            }
        }
    }

    public void printTree()
    {
        printNode(this.root);
    }
    public void printNode(Node n)
    {
        if(n != null)
        {
            printNode(n.left);
            System.out.println(n.value);
            printNode(n.right);
        }
    }
}
