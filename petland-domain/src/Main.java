import java.time.LocalDate;
import java.time.LocalTime;

import com.petland.domain.atendimento.Atendimento;
import com.petland.domain.atendimento.AtendimentoStatus;
import com.petland.domain.atendimento.AtendimentoTipo;
import com.petland.domain.cadastro.Animal;
import com.petland.domain.cadastro.Cadastro;
import com.petland.domain.cadastro.Endereco;
import com.petland.domain.cadastro.Especie;
import com.petland.domain.cadastro.Perfil;
import com.petland.domain.cadastro.ProdutoServico;

public class Main {
    public static void main(String[] args) throws Exception {
        Perfil perfil = new Perfil();
        perfil.setCliente(true);

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua do lugar nenhum");
        endereco.setNumero("123A");

        Cadastro cadastro = new Cadastro();
        cadastro.setId(1);
        cadastro.setNome("Vinícius Massari");
        cadastro.setPerfil(perfil);
        cadastro.setEndereco(endereco);

        Animal animal = new Animal();
        animal.setId(1);
        animal.setNome("Thor");
        animal.setAniversario(LocalDate.of(2023, 10, 12));
        animal.setEspecie(Especie.GATO);

        ProdutoServico servico = new ProdutoServico();
        servico.setId(1);
        servico.setServico(true);
        servico.setNome("Vacina contra raiva");
        servico.setValor(30.00);

        Atendimento atendimento = new Atendimento();
        atendimento.setId(1);
        atendimento.setData(LocalDate.now());
        atendimento.setHora(LocalTime.now());
        atendimento.setDescricao(servico.getNome());
        atendimento.setStatus(AtendimentoStatus.REALIZANDO);
        atendimento.setTipo(AtendimentoTipo.VACINACAO);
        atendimento.setValor(60.00);

        atendimento.setPaciente(animal);
        atendimento.setServico(servico);
        atendimento.setSolicitante(cadastro);

        System.out.println(atendimento);

    }
}
