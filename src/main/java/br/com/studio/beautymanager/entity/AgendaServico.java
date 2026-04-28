package br.com.studio.beautymanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "agenda_servico")
public class AgendaServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

    @Column(name = "servico_id")
    private Long servicoId;

    private Integer ordem;
    private Integer duracaoMinutos;
    
    public void setDuracaoMinutos(Integer duracao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDuracaoMinutos'");
    }

    public void setAgenda(Agenda salva) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAgenda'");
    }

    public void setOrdem(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOrdem'");
    }
}
