package com.example.manueleagzample.splashscreen.service;

import com.example.manueleagzample.splashscreen.models.ReservedBook;

import java.util.ArrayList;

public class ReserveBookService {
        private static ArrayList<ReservedBook> reservedBooks = new ArrayList<>();

        public static ArrayList<ReservedBook> getAllReserveBook() {
            return reservedBooks;
        }

        public static String addReservedBook(ReservedBook book) {
            if (reservedBooks.size() == 0) {
                reservedBooks.add(book);
                return "Book Reserved";
            }else{
                for (ReservedBook b: reservedBooks) {
                    if(b.getBook().getBookid().equalsIgnoreCase(book.getBook().getBookid())) {
                        return "You have already reserved this book";
                    }
                }

                reservedBooks.add(book);
                book.getBook().setCount(book.getBook().getCount()-1);
            }

            return "Book reserved";
        }

//        public static ArrayList<LibraryBooks> filterBooks(String param){
//            ArrayList<LibraryBooks> returnBooks = new ArrayList<>();
//
//            for (ReserveBookService book: books) {
//                if(book.getAuthor().equals(param) || book.getTitle().equals(param)) {
//                    returnBooks.add(book);
//                }
//            }
//
//            return returnBooks;
//        }

    public static ReservedBook getBookById(String id) {
          ReservedBook book = new ReservedBook();
           for (ReservedBook b: reservedBooks) {
              if(b.getBook().getBookid().equalsIgnoreCase(id)) {
                    book = b;
               }
            }
    return book;
       }
}
