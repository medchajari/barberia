package Entidades;

public class Local {
    private int idLocal;
    private String nombreLocal;

    // Constructor por defecto
    public Local() {
    }

    // Constructor que acepta el ID
    public Local(int idLocal) {
        this.idLocal = idLocal;
    }

    public Local(int idLocal, String nombreLocal) {
        this.idLocal = idLocal;
        this.nombreLocal = nombreLocal;
    }
    
    

    // Getters y setters
    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }
}