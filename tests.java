/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testlogin;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 * @author RLAMA
 */
@RunWith(Cucumber.class)
@Cucumber.Options(features="features",
        glue={"testCases"})
public class tests {
    
}
