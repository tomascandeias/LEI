import java.util.ArrayList;
import java.util.regex.Pattern;

public class Empresa {
    String nome, codigoPostal, email;
    ArrayList<Veiculo> veiculos;

    public Empresa(String nome, String codigoPostal, String email) {
        this.nome = nome;
        this.veiculos = new ArrayList<Veiculo>();
        if (validEmail(email))
            this.email = email;
        if (validCP(codigoPostal))
            this.codigoPostal = codigoPostal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        if (validCP(codigoPostal))
            this.codigoPostal = codigoPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (validEmail(email))
            this.email = email;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void addVeiculo(Veiculo v){
        veiculos.add(v);
    }

    public void removeVeiculo(Veiculo v){
        if (veiculos.contains(v))
            veiculos.remove(v);
    }

    public void removeAllVeiculos(){
        veiculos.clear();
    }


    private static boolean validEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
        Pattern p = Pattern.compile(emailRegex);

        if (email == null)
            return false;

        return p.matcher(email).matches();
    }

    private static boolean validCP(String cp){ // _ _ _ _ - _ _ _ estrutura codigo postal
        char[] c = cp.toCharArray();
        if (c[4] == '-'){
               for (int i=0; i<4; i++){
                   if (!Character.isDigit(c[i]))
                       return false;
               }

            for (int i=5; i<=7; i++){
                if (!Character.isDigit(c[i]))
                    return false;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String s = nome + " , " + codigoPostal + " , " + email;
        if (veiculos.size() == 0) {
            s += "0 veiculos associados";
        }else{
            s+=veiculos.toString();
        }
        return s;
    }
}
