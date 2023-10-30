package com.desafio.laboratorio.configuracao;
import com.desafio.laboratorio.entidade.Exame;
import com.desafio.laboratorio.entidade.Laboratorio;
import com.desafio.laboratorio.entidade.Status;
import com.desafio.laboratorio.entidade.TipoExame;
import com.desafio.laboratorio.repositorio.ExameRepositorio;
import com.desafio.laboratorio.repositorio.LaboratorioRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarregaBanco {

    @Bean
    CommandLineRunner initDatabase(ExameRepositorio exameRepositorio, LaboratorioRepositorio laboratorioRepositorio) {
        return args -> {
            Exame exame = new Exame("Hemograma", Status.ATIVO, TipoExame.ANALISE_CLINICA);
            Laboratorio laboratorio = new Laboratorio("Laboratório GQS", "Santos", Status.ATIVO);
            exameRepositorio.save(exame);
            laboratorioRepositorio.save(laboratorio);
            exame.getListaLaboratorios().add(laboratorio);
            exameRepositorio.save(exame);
        };
    }
}
