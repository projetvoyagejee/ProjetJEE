/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author Julien Modena
 */
public class Article {
    private int id_Articles;
    private String title;
    private String body;
    private String img;
    private String date;
    private String dateMAJ;
    private int up;
    private int down;

    public int getId_Articles() {
        return id_Articles;
    }

    public void setId_Articles(int id_Articles) {
        this.id_Articles = id_Articles;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateMAJ() {
        return dateMAJ;
    }

    public void setDateMAJ(String dateMAJ) {
        this.dateMAJ = dateMAJ;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public Article() {
    }

    public Article(int id_Articles, String title, String body, String img, String date, String dateMAJ, int up, int down) {
        this.id_Articles = id_Articles;
        this.title = title;
        this.body = body;
        this.img = img;
        this.date = date;
        this.dateMAJ = dateMAJ;
        this.up = up;
        this.down = down;
    }
    
    

    
}
