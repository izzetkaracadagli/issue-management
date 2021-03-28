package com.karacadaglii.issuemanagement.Entity.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issue")
@Data //Getter and Setter yaratır. Data modeli haline getirir
@NoArgsConstructor //Bu nesnenin boş bir constructor ını yaratır
@AllArgsConstructor //Tum fieldları kullanan contructor
@ToString //toString override eder
@EqualsAndHashCode // Equals ve hashcode methodunu override eder
public class Issue extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description", length = 400)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    //Issue tablosuna select atıldıgında User da gelsin mi sorusunun cevabıdır
    // Lazy dediğimizde sadece ihtiyacımız oldugunda getirilir.
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Project project;
}
