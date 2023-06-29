package br.edu.ifsuldeminas.mch.webii.crudmanager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.MissionRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.CopRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.*;

@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner {

    @Autowired
    private CopRepository copRepository;

    @Autowired
    private MissionRepository missionRepository;

    @Override
    public void run(String... args) throws Exception {
        // Simulação de um banco de dados.

        Cop albertWesker = new Cop();
        albertWesker.setName("Albert Wesker");
        albertWesker.setRank("S.T.A.R.S. Captain");
        albertWesker.setGender("M");

        Cop jillValentine = new Cop();
        jillValentine.setName("Jill Valentine");
        jillValentine.setRank("S.T.A.R.S. Officer");
        jillValentine.setGender("F");

        Cop chrisRedfield = new Cop();
        chrisRedfield.setName("Chris Redfield");
        chrisRedfield.setRank("S.T.A.R.S. Officer");
        chrisRedfield.setGender("M");

        Cop barryBurton = new Cop();
        barryBurton.setName("Barry Burton");
        barryBurton.setRank("S.T.A.R.S. Officer");
        barryBurton.setGender("M");

        Cop rebeccaChambers = new Cop();
        rebeccaChambers.setName("Rebecca Chambers");
        rebeccaChambers.setRank("S.T.A.R.S. Officer");
        rebeccaChambers.setGender("F");

        Cop josephFrost = new Cop();
        josephFrost.setName("Joseph Frost");
        josephFrost.setRank("S.T.A.R.S. Officer");
        josephFrost.setGender("M");

        Cop bradVickers = new Cop();
        bradVickers.setName("Brad Vickers");
        bradVickers.setRank("S.T.A.R.S. Officer");
        bradVickers.setGender("M");
        
        Cop leonSKennedy = new Cop();
        leonSKennedy.setName("Leon S. Kennedy");
        leonSKennedy.setRank("Police Officer of Raccon City");
        leonSKennedy.setGender("M");

        copRepository.save(albertWesker);
        copRepository.save(jillValentine);
        copRepository.save(chrisRedfield);
        copRepository.save(barryBurton);
        copRepository.save(rebeccaChambers);
        copRepository.save(josephFrost);
        copRepository.save(bradVickers);
        copRepository.save(leonSKennedy);

        Mission mansionIncident = new Mission();
        mansionIncident.setName("Resgate da equipe Bravo");
        mansionIncident.setLocal("Montanhas de Arklay");
        mansionIncident.setDescription("Sob o comando de Albert Wesker, a equipe Alpha dos S.T.A.R.S. foi enviada para a região das Montanhas de Arklay "
                + "para averiguar o que aconteceu com seus companheiros da equipe Bravo, "
                + "enviados para investigar bizarros casos de assassinatos de canibalismo, "
                + "mas que não retornaram e nem estabeleceram contato com a base nas últimas 24 horas.");

        mansionIncident.getCops().add(albertWesker);
        mansionIncident.getCops().add(jillValentine);
        mansionIncident.getCops().add(chrisRedfield);
        mansionIncident.getCops().add(barryBurton);
        mansionIncident.getCops().add(rebeccaChambers);
        mansionIncident.getCops().add(bradVickers);
        mansionIncident.getCops().add(josephFrost);

        missionRepository.save(mansionIncident);
        
        Mission raccoonIncident = new Mission();
        raccoonIncident.setName("Tragédia de Raccoon City");
        raccoonIncident.setLocal("Raccoon City");
        raccoonIncident.setDescription("Foi um surto viral catastrófico que ocorreu em etapas entre maio e outubro de 1998, "
        		+ "resultando na destruição da cidade em um bombardeio de mísseis, codinome \"XX\".");
        
        raccoonIncident.getCops().add(jillValentine);
        raccoonIncident.getCops().add(leonSKennedy);
        raccoonIncident.getCops().add(bradVickers);
        
        
        missionRepository.save(raccoonIncident);
    }
}
