package com.sjtuse.zcbookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by zcoaolas on 3/18/2017.
 */
@Data
@NoArgsConstructor
public class Book {
    private Integer bookId;
    private String bookName;
    private BigDecimal bookPrice;
    private String bookInfo;
    private String bookAuthor;
    private String category;

    /*public Integer getBookId(){
        return bookId;
    }
    public void setBookId(Integer bookId){
        this.bookId = bookId;
    }
    public String getBookName(){
        return bookName;
    }
    public void setBookName(String bookName){
        this.bookName = bookName;
    }
    public BigDecimal getBookPrice(){
        return bookPrice;
    }
    public void setBookPrice(BigDecimal bookPrice){
        this.bookPrice = bookPrice;
    }
    public String getBookInfo(){
        return bookInfo;
    }
    public void setBookInfo(String bookInfo){
        this.bookInfo = bookInfo;
    }
    public String getBookAuthor(){
        return bookAuthor;
    }
    public void setBookAuthor(String bookAuthor){
        this.bookAuthor = bookAuthor;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean equals(Book bookToCompare){
        return this.bookId.equals(bookToCompare.bookId) &&
                this.bookName.equals(bookToCompare.bookName) &&
                this.bookPrice.equals(bookToCompare.bookPrice) &&
                this.bookInfo.equals(bookToCompare.bookInfo) &&
                this.bookAuthor.equals(bookToCompare.bookAuthor) &&
                this.category.equals(bookToCompare.category);
    }*/
}
