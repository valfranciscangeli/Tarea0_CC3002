public class Novel extends LiteraryWork{
    // parametros
    private String author;

    // constructor sin copyright
    public Novel(String aTitle, String anEditorial, String anAuthor){
        super(aTitle,anEditorial);
        this.author = anAuthor;
    }

    // constructor con copyright
    public Novel(String aTitle, String anEditorial, String anAuthor, String aCopyright){
        super(aTitle,anEditorial,aCopyright);
        this.author = anAuthor;
    }

    // metodos para recuperar informacion de los campos
    public String getAuthor() {
        return author;
    }

    // Metodo para pasar contenido de una Movie a un string que lo describa
    @Override
    public String toString() {
        return "Novel{" +
                "title='" + this.getTitle() + '\'' +
                ", publisher='" + this.getPublisher() + '\'' +
                ", author='" + author + '\'' +
                ", copyright='" + this.getCopyright() + '\'' +
                '}';
    }

    // Metodo equals para comparar si 2 Movies son iguales (en memoria y/o en contenido)
    @Override
    public boolean equals(Object otherNovel) {
        //iguales si son exactamente el mismo dato en la memoria
        if (this == otherNovel) return true;
        // no son iguales si el otro no es de clase Novel
        if (!(otherNovel instanceof Novel)) return false;
        // si nunguno tiene copyright comparamos los titulos y editorial
        if (this.getCopyright()==null && ((Novel) otherNovel).getCopyright()==null){
            return ((Novel) otherNovel).getTitle().equals(this.getTitle()) &&
                    ((Novel)otherNovel).getPublisher().equals(this.getPublisher()) &&
                    ((Novel)otherNovel).author.equals(this.author);
        }
        // comparamos titulos y copyright
        if (this.getCopyright()!=null && ((Novel) otherNovel).getCopyright()!=null){
            return ((Novel) otherNovel).getTitle().equals(this.getTitle()) &&
                    ((Novel)otherNovel).getPublisher().equals(this.getPublisher()) &&
                    ((Novel)otherNovel).author.equals(this.author) &&
                    ((Novel)otherNovel).getCopyright().equals(this.getCopyright());
        }
        // otro caso: no son iguales
        return false;
    }
}