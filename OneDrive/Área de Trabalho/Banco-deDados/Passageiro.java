import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "passageiros")
public class Passageiro {
    @DatabaseField(id = true)
    private String cpf;

    @DatabaseField
    private String nome;

    public Passageiro() {
        // ORMLite needs a no-arg constructor
    }

    public Passageiro(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\nNome:" + nome + "\nCpf:" + cpf;
    }
}
