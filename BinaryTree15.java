public class BinaryTree15 {
    Node15 root;

    public BinaryTree15() {
        root = null;    
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Mahasiswa15 mahasiswa) {
        Node15 newNode = new Node15(mahasiswa);
        if (isEmpty()) {
            root = newNode;
        }else {
            Node15 current = root;
            Node15 parent = null;
            while (true) {
                parent = current;
                if (mahasiswa.ipk < current.mahasiswa.ipk){
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                }else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    boolean find (double ipk) {
        boolean result = false;
        Node15 current = root;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.mahasiswa.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }  

    void traversePreOrder(Node15 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traverseInOrder(Node15 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    void traversePostOrder(Node15 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    Node15 getSuccesor(Node15 del) {
        Node15 succesor = del.right;
        Node15 sucessorParent = del;
        while (succesor.left != null) {
            sucessorParent = succesor;
            succesor = succesor.left;
        }
        if (succesor != del.right) {
            sucessorParent.left = succesor.right;
            succesor.right = del.right;
        }
        return succesor;
    }

    void delete(double ipk)  {
        if (isEmpty()) {
            System.out.println("Binnary tree kososng");
            return;
        }
        //cari node (current) yang akan dihapus
        Node15 parent = root;
        Node15 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                break;
            } else if (ipk < current.mahasiswa.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (ipk > current.mahasiswa.ipk) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }
        //penghapusan
        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;
        } else {
            //jika tidak ada anak (leaf), maka node dihapus
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if(current.left == null) { //jika hanya punya 1 anak (kanan)
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            } else if(current.right == null) { //jika hanya punya 1 anak (
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else if (true) { //jika punya 2 anak
                Node15 succesor = getSuccesor(current);
                System.out.println("Jika 2 anak, current = ");
                succesor.mahasiswa.tampilInformasi();
                if(current == root) {
                    root = succesor;
                } else {
                    if (isLeftChild) {
                        parent.left = succesor;
                    } else {
                        parent.right = succesor;
                    }
                }
                succesor.left = current.left;
            }
        }
    }
}