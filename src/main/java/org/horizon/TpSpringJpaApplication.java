package org.horizon;

import org.horizon.dao.PlayerRepository;
import org.horizon.dao.TeamRepository;
import org.horizon.entities.Player;
import org.horizon.entities.Team;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class TpSpringJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(TpSpringJpaApplication.class, args);

		TeamRepository dao=ctx.getBean(TeamRepository.class);
		PlayerRepository playerRepository=ctx.getBean(PlayerRepository.class);

		Team t1=dao.save(new Team(null,"FC Porto"));
		Team t2=dao.save(new Team(null,"FC Bayern"));
		Team t3=dao.save(new Team(null,"Paris FC"));
		Team t4=dao.save(new Team(null,"Milan"));
		Team t5=dao.save(new Team(null,"Juventus"));

		playerRepository.save(new Player(null, "Mane",t2 ));
		playerRepository.save(new Player(null, "PePe",t1 ));
		playerRepository.save(new Player(null, "Neymar",t3 ));
		playerRepository.save(new Player(null, "Leao",t4 ));
		playerRepository.save(new Player(null, "Pogba",t5 ));

		List<Team> teamList=dao.getTeamsByName("FC");
		for(Team team:teamList){
			System.out.println("Team: "+team.getName());
		}
	}

}
