package br.edu.raone.receitas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Informe o nome da receita.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String nome;

    @NotBlank(message = "Informe a categoria.")
    @Size(max = 50, message = "A categoria pode ter no maximo 50 caracteres.")
    private String categoria;

    @NotBlank(message = "Informe os ingredientes.")
    @Size(min = 10, max = 1000, message = "Os ingredientes devem ter entre 10 e 1000 caracteres.")
    private String ingredientes;

    @NotBlank(message = "Informe o modo de preparo.")
    @Size(min = 10, max = 2000, message = "O modo de preparo deve ter entre 10 e 2000 caracteres.")
    private String modoPreparo;

    @NotNull(message = "Informe o tempo de preparo.")
    @Min(value = 1, message = "O tempo de preparo deve ser de pelo menos 1 minuto.")
    @Max(value = 1440, message = "O tempo de preparo deve ser de no maximo 1440 minutos.")
    private Integer tempoPreparo;

    @NotNull(message = "Informe o rendimento.")
    @Min(value = 1, message = "O rendimento deve ser de pelo menos 1 porcao.")
    @Max(value = 100, message = "O rendimento deve ser de no maximo 100 porcoes.")
    private Integer rendimento;

    @NotBlank(message = "Selecione a dificuldade.")
    private String dificuldade;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getIngredientes() { return ingredientes; }
    public void setIngredientes(String ingredientes) { this.ingredientes = ingredientes; }
    public String getModoPreparo() { return modoPreparo; }
    public void setModoPreparo(String modoPreparo) { this.modoPreparo = modoPreparo; }
    public Integer getTempoPreparo() { return tempoPreparo; }
    public void setTempoPreparo(Integer tempoPreparo) { this.tempoPreparo = tempoPreparo; }
    public Integer getRendimento() { return rendimento; }
    public void setRendimento(Integer rendimento) { this.rendimento = rendimento; }
    public String getDificuldade() { return dificuldade; }
    public void setDificuldade(String dificuldade) { this.dificuldade = dificuldade; }
}
