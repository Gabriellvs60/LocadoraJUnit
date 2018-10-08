
import local.model.ClienteTest;
import local.model.FilmeTest;
import local.service.LocacaoServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leandro
 */
@RunWith(Suite.class)
@SuiteClasses({FilmeTest.class,
               ClienteTest.class,
               LocacaoServiceTest.class})

public class AllTestes {

}
