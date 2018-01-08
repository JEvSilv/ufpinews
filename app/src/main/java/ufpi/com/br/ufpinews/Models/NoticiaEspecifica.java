package ufpi.com.br.ufpinews.Models;

/**
 * Created by jonin on 10/11/2017.
 */

public class NoticiaEspecifica {
    public Boolean etext;
    public String text;
    public Boolean link;
    public String href;
    public Boolean eimg;
    public String img;

    public NoticiaEspecifica(Boolean etext, String text, Boolean link, String href, Boolean eimg, String img) {
        this.text = text;
        this.href = href;
        this.img = img;
        this.link = link;
        this.eimg = eimg;
        this.etext = etext;
    }

    public String getTexto() {
        return text;
    }

    public void setTexto(String texto) {
        this.text = texto;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Boolean getLink() {
        return link;
    }

    public void setLink(Boolean link) {
        this.link = link;
    }

    public Boolean getEimg() {
        return eimg;
    }

    public void setEimg(Boolean eimg) {
        this.eimg = eimg;
    }

    public Boolean getEtext() {
        return etext;
    }

    public void setEtext(Boolean etext) {
        this.etext = etext;
    }
}
