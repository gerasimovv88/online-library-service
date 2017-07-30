package org.vladigeras.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "Book", schema = "OnlineLibrary")
public class BookEntity {
    private long id;
    private String title;
    private Integer year;
    private Integer pages;
    private String publisher;
    private Double averageRating;
    private String isbn;
    private byte[] image;
    private byte[] content;
    private String description;
    private Collection<BookAuthorEntity> bookAuthorsById;
    private Collection<BookGenreEntity> bookGenresById;

    public BookEntity() {

    }

    public BookEntity(String title, Integer year, Integer pages, String publisher, Double averageRating, String isbn, byte[] image, byte[] content, String description) {
        this.title = title;
        this.year = year;
        this.pages = pages;
        this.publisher = publisher;
        this.averageRating = averageRating;
        this.isbn = isbn;
        this.image = image;
        this.content = content;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "pages")
    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Basic
    @Column(name = "publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Basic
    @Column(name = "average_rating")
    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    @Basic
    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @Column(name = "content")
    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        if (pages != null ? !pages.equals(that.pages) : that.pages != null) return false;
        if (publisher != null ? !publisher.equals(that.publisher) : that.publisher != null) return false;
        if (averageRating != null ? !averageRating.equals(that.averageRating) : that.averageRating != null)
            return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;
        if (!Arrays.equals(image, that.image)) return false;
        if (!Arrays.equals(content, that.content)) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (averageRating != null ? averageRating.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + Arrays.hashCode(content);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<BookAuthorEntity> getBookAuthorsById() {
        return bookAuthorsById;
    }

    public void setBookAuthorsById(Collection<BookAuthorEntity> bookAuthorsById) {
        this.bookAuthorsById = bookAuthorsById;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<BookGenreEntity> getBookGenresById() {
        return bookGenresById;
    }

    public void setBookGenresById(Collection<BookGenreEntity> bookGenresById) {
        this.bookGenresById = bookGenresById;
    }
}
