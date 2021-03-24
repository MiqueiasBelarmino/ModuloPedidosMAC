package modelo;

/**
 *
 * @author Miquéias
 */
public class Cliente {
    
      private int EmpCodigo;  
      private int pCodigo;
      private int codigoAntigo;
      private String PTipo;
      private String PFCPF;
      private String PJCNPJ;
      private String NomeRazaoSocial;
      private String Email;
      private String Telefone;
      private String PJInscricaoEstadual;
      private String Cidade;
      private String PJEndereco;
      private String PJBairro;
      private String PJCEP;
      private String PJUF;
      private String PFEndereco;
      private String PFBairro;
      private String PFCEP;
      private String PFUF;

    public int getEmpCodigo() {
        return EmpCodigo;
    }

    public void setEmpCodigo(int EmpCodigo) {
        this.EmpCodigo = EmpCodigo;
    }

    public int getpCodigo() {
        return pCodigo;
    }

    public void setpCodigo(int pCodigo) {
        this.pCodigo = pCodigo;
    }

    public int getCodigoAntigo() {
        return codigoAntigo;
    }

    public void setCodigoAntigo(int codigoAntigo) {
        this.codigoAntigo = codigoAntigo;
    }
    

    public String getPTipo() {
        return PTipo;
    }

    public void setPTipo(String PTipo) {
        this.PTipo = PTipo;
    }

    public String getPFCPF() {
        return PFCPF;
    }

    public void setPFCPF(String PFCPF) {
        this.PFCPF = PFCPF;
    }

    public String getPJCNPJ() {
        return PJCNPJ;
    }

    public void setPJCNPJ(String PJCNPJ) {
        this.PJCNPJ = PJCNPJ;
    }

    public String getNomeRazaoSocial() {
        return NomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String NomeRazaoSocial) {
        this.NomeRazaoSocial = NomeRazaoSocial;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getPJInscricaoEstadual() {
        return PJInscricaoEstadual;
    }

    public void setPJInscricaoEstadual(String PJInscricaoEstadual) {
        this.PJInscricaoEstadual = PJInscricaoEstadual;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getPJEndereco() {
        return PJEndereco;
    }

    public void setPJEndereco(String PJEndereco) {
        this.PJEndereco = PJEndereco;
    }

    public String getPJBairro() {
        return PJBairro;
    }

    public void setPJBairro(String PJBairro) {
        this.PJBairro = PJBairro;
    }

    public String getPJCEP() {
        return PJCEP;
    }

    public void setPJCEP(String PJCEP) {
        this.PJCEP = PJCEP;
    }

    public String getPJUF() {
        return PJUF;
    }

    public void setPJUF(String PJUF) {
        this.PJUF = PJUF;
    }

    public String getPFEndereco() {
        return PFEndereco;
    }

    public void setPFEndereco(String PFEndereco) {
        this.PFEndereco = PFEndereco;
    }

    public String getPFBairro() {
        return PFBairro;
    }

    public void setPFBairro(String PFBairro) {
        this.PFBairro = PFBairro;
    }

    public String getPFCEP() {
        return PFCEP;
    }

    public void setPFCEP(String PFCEP) {
        this.PFCEP = PFCEP;
    }

    public String getPFUF() {
        return PFUF;
    }

    public void setPFUF(String PFUF) {
        this.PFUF = PFUF;
    }

    @Override
    public String toString() {
        return codigoAntigo + " - " + NomeRazaoSocial;
    }
      
      
    
      
    
}
