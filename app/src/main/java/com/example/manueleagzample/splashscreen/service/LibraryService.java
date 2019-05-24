package com.example.manueleagzample.splashscreen.service;

import com.example.manueleagzample.splashscreen.models.LibraryBooks;

import java.util.ArrayList;

public class LibraryService {
    private static ArrayList<LibraryBooks> books = new ArrayList<>();

    public static ArrayList<LibraryBooks> getAllLibraryBooks() {
        return books;
    }

    public static void addLibrary(LibraryBooks book) {
        books.add(book);
    }

    public static ArrayList<LibraryBooks> filterBooks(String param){
        ArrayList<LibraryBooks> returnBooks = new ArrayList<>();

        for (LibraryBooks book: books) {
            if(book.getAuthor().equals(param) || book.getTitle().equals(param)) {
                returnBooks.add(book);
            }
        }

        return returnBooks;
    }

    public static ArrayList<LibraryBooks> getEbooks() {
        ArrayList<LibraryBooks> e_books = new ArrayList<>();

        for (LibraryBooks book: books) {
            if(book.getPdfsupported()) {
                e_books.add(book);
            }
        }

        return e_books;
    }

    public static LibraryBooks getBookById(String id) {
        LibraryBooks book = new LibraryBooks();
        for (LibraryBooks b: books) {
            if(b.getBookid().equalsIgnoreCase(id)) {
                book = b;
            }
        }
        return book;
    }

    public static void generateBooks() {
        if (books.size() == 0) {
            LibraryBooks book1 = new LibraryBooks("Java Simplified", "AP001", "Dr. Daniel Agbemava" ,"Programming" ,true ,true,false,10, "", null, "http://maven.apache.org/maven-1.x/maven.pdf");
            LibraryBooks book2 = new LibraryBooks("Introduction to mathematics", "AM002", "Miss.Matilda Ampoma" ,"Mathematics" , true ,false ,false ,8,"",null, null);
            LibraryBooks book3= new LibraryBooks("Introduction to discrete mathematics", "AM003", "Miss.Matilda Ampoma" ,"Mathematics" ,false ,true ,true ,3, "", null, null);
            LibraryBooks book4= new LibraryBooks("Simplified to code in VB", "AP004", "Miss.Theresa Ebuoh" ,"Programming" ,true, false,false ,9,"",null, null);
            LibraryBooks book5= new LibraryBooks("C++ in a bit", "AP005", "Farida Beacher-Yor" ,"Programming",false, true,true,11,"",null, null);
            LibraryBooks book6= new LibraryBooks("Organic Chemistry", "AC006", "Enyonam Oheneba" ,"Chemistry",true, true,false,12,"",null, null);
            LibraryBooks book7= new LibraryBooks("introduction to inorganic Chemistry ", "AC007","Enyonam Oheneba","Chemistry" ,false,true,true,2,"",null, null);
            LibraryBooks book8= new LibraryBooks("Statistics in a brief 1", "AS008", "Enyonam Oheneba","Statistics" ,true,false,false,12,"",null,null);
            LibraryBooks book9= new LibraryBooks("Statistics as a whole", "AS009", "Maame Yeboah" ,"Statistics",true, true,false,14,"",null, null);
            LibraryBooks book10= new LibraryBooks("Statistics in a brief 2", "AB010", "Enyonam Oheneba","Statistics",false,true,true,2,"",null, null);
            LibraryBooks book11= new LibraryBooks("Digestive system", "AB011", "Eyram Yawa","Biology",false,true,true,3,"",null, "http://maven.apache.org/maven-1.x/maven.pdf");
            LibraryBooks book12= new LibraryBooks("Respiratory system", "AB012", "Enyonam Oheneba","Biology",true,false,false,15,"",null,null);
            LibraryBooks book13= new LibraryBooks("the actuarary's corner", "AA013", "Enyonam Oheneba","Actuarial Science", true,true,false,10,"",null,"http://maven.apache.org/maven-1.x/maven.pdf");
            LibraryBooks book14= new LibraryBooks("Pure Mathematics", "AM014", "Enyonam Oheneba","Mathematics",true,true,false,15,"",null, "http://maven.apache.org/maven-1.x/maven.pdf");
            LibraryBooks book15= new LibraryBooks("Introduction to Actuarial Science", "AB015", "Oheneba Yeboah","Actuarial Science",true,false,false,16,"",null,null);



            books.add(book1);
            books.add(book2);
            books.add(book3);
            books.add(book4);
            books.add(book5);
            books.add(book6);
            books.add(book7);
            books.add(book8);
            books.add(book9);
            books.add(book10);
            books.add(book11);
            books.add(book12);
            books.add(book13);
            books.add(book14);
            books.add(book15);

        }

    }
}

