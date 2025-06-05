public class BinaryTreeMain15 {
    public static void main(String[] args) {
    BinaryTree15 bst = new BinaryTree15();

    bst.add(new Mahasiswa15("2441061021", "Ali", "A", 3.57));
    bst.add(new Mahasiswa15("2441061021", "Badar", "B", 3.85));
    bst.add(new Mahasiswa15("2441061025", "Candra", "C", 3.21));
    bst.add(new Mahasiswa15("2441062020", "Dewi", "B", 3.54));

    System.out.println("\nDaftar semua mahasiswa (in order traversal):");
    bst.traverseInOrder(bst.root);

    System.out.println("\nPencarian data mahasiswa:");
    System.out.print("Cari mahasiswa dengan ipk: 3.54 : ");
    String hasilCari = bst.find(3.54) ? "Ditemukan" : "Tidak ditemukan";
    System.out.println(hasilCari);

    System.out.print("Cari mahasiswa dengan ipk: 3.22 : ");
    hasilCari = bst.find(3.22) ? "Ditemukan" : "Tidak ditemukan";
    System.out.println(hasilCari);

    bst.add(new Mahasiswa15("2441061031", "Devi", "A", 3.72));
    bst.add(new Mahasiswa15("2441062005", "Ehsan", "D", 3.37));
    bst.add(new Mahasiswa15("2441061070", "Fizi", "B", 3.46));
    System.out.println("\nDaftar semua mahasiswa setelah penambahan 3 mahasiswa:");
    System.out.println("InOrder Traversal:");
    bst.traverseInOrder(bst.root);
    System.out.println("\nPreOrder Traversal:");
    bst.traversePreOrder(bst.root);
    System.out.println("\nPostOrder Traversal:");
    bst.traversePostOrder(bst.root);
    
    System.out.println("\nPenghapusan data mahasiswa");
    bst.delete(3.57);
    System.out.println("\nDaftar semua mahasiswa setelah penghapusan 1 mahasiswa(in order traversal):");
    bst.traverseInOrder(bst.root);

    // Tambahan untuk jawaban 1-3 Tugas Praktikum
    System.out.println("\n\n== Penambahan Mahasiswa dengan Rekursif ==");
    bst.addRekursif(new Mahasiswa15("2441061099", "Gita", "A", 3.65));        bst.addRekursif(new Mahasiswa15("2441061100", "Hasan", "B", 3.20));

    System.out.println("\nInOrder Traversal setelah addRekursif:");
    bst.traverseInOrder(bst.root);

    System.out.println("\n== Mahasiswa dengan IPK Paling Kecil ==");
    bst.cariMinIPK();

    System.out.println("\n== Mahasiswa dengan IPK Paling Besar ==");
    bst.cariMaxIPK();
    
    System.out.println("\n== Mahasiswa dengan IPK di atas 3.50 ==");
    bst.tampilMahasiswaIPKdiAtas(3.50);
    }
} 