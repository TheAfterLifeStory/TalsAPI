package talsapi.talsapi.api;

import talsapi.talsapi.mysql.*;

public class MySQLAPI {

    public MySQLAPI()
    {
    }

    public Assassin getAssassin() { return new Assassin(); }
    public Guardian getGuardian() { return new Guardian(); }
    public Hunter getHunter() { return new Hunter(); }
    public Necromancer getNecromancer() { return new Necromancer(); }
    public Priest getPriest() { return new Priest(); }
    public Soldier getSoldier() { return new Soldier(); }
    public Thief geThief() { return new Thief(); }
    public Wizard getWizard() { return new Wizard(); }
}
