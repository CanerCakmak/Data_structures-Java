/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._caner_cakmak;
import java.util.Scanner;

/**
 *
 * @author Caner
 */



public class App {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Balon sayisini giriniz: ");
        int n = scanner.nextInt();
        System.out.print("Atlanacak balon sayisini giriniz: ");
        int m = scanner.nextInt();

        balonPozisyonuBul(m, n);
    }

    static void balonPozisyonuBul(int m, int n) {
        // N adet balondan oluşacak dairesel bağlı listeyi oluşturma
        Node head = new Node(1);
        Node current = head;
        for (int i = 2; i <= n; i++) 
        {
            current.next = new Node(i);
            current = current.next;
        }
        
        current.next = head; // son düğümün gösterdiği next düğüm head'e bağlanır

        // Listenin sonunda kalacak balonu bulma
        while (current.next != current) {
            // M-1 balon atlanır
            for (int i = 0; i < m - 1; i++) {
                current = current.next;
            }
            // m-1 den sonra gelen balon patlatılır
            Node temp = current.next;
            current.next = temp.next;
            temp = null;
        }

        System.out.println("Patlamayan Balonun Pozisyonu: " + current.data);
    }
}

