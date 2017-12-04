package ufpi.com.br.ufpinews.Models;

/**
 * Created by jonin on 10/11/2017.
 */

public class NoticiaEspecifica {
    public String texto;
    public String href;
    public String img;
    public Boolean link;
    public Boolean eimg;
    public Boolean etext;

    public NoticiaEspecifica(String texto, String href, String img, Boolean link, Boolean eimg, Boolean etext) {
        this.texto = texto;
        this.href = href;
        this.img = img;
        this.link = link;
        this.eimg = eimg;
        this.etext = etext;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
