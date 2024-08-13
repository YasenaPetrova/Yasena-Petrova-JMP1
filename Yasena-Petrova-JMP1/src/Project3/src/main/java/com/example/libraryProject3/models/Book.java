package com.example.libraryProject3.models;

public class Book {
    private long id;
    private String nameBook;
    private String genre;
    private int pages;
    private int stars;
    private int authorID;
    private boolean makePublic;
    public Book() {}

    public Book( String nameBook, String genre, int pages, int stars, int authorID, boolean makePublic) {

        this.nameBook = nameBook;
        this.genre = genre;
        this.pages = pages;
        this.stars = stars;
        this.authorID = authorID;
        this.makePublic = makePublic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public boolean isMakePublic() {
        return makePublic;
    }

    public void setMakePublic(boolean makePublic) {
        this.makePublic = makePublic;
    }
}
