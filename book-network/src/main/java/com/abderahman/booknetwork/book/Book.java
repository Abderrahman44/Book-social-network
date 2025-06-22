package com.abderahman.booknetwork.book;

import com.abderahman.booknetwork.common.BaseEntity;
import com.abderahman.booknetwork.feedback.Feedback;
import com.abderahman.booknetwork.history.BookTransactionHistory;
import com.abderahman.booknetwork.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;

import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {


    private String title;
    private String author;
    private String isbn;
    private String synopsis;
    private String bookCover;
    private boolean archived;
    private boolean shareable;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "book")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "book")
    private List<BookTransactionHistory> TransactionHistories;

    @OneToOne(fetch = FetchType.EAGER)
    private BookTransactionHistory transactionHistory;
}
