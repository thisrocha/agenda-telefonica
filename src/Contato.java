public class Contato {
    private String nome ;
    private String telefone;
    private String email;
    private String tags;

    @Override
    public String toString() {
        return  "\n--- Contato ---" +
                "\nNome     : " + nome +
                "\nTelefone : " + telefone +
                "\nEmail    : " + email +
                "\nTags     : " + tags +
                "\n----------------";
    }


    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Contato(String nome, String telefone, String email, String tags) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.tags = tags;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getTags() {
        return tags;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void editarTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void editarNome(String nome){
        this.nome = nome;
    }
}
