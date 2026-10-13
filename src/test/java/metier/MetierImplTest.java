package metier;

import dao.IDao;
import org.junit.Assert;
import org.junit.Test;

public class MetierImplTest {

    @Test
    public void testCalcul() {
        // DAO fictif : retourne toujours 10.0
        IDao dao = new IDao() {
            @Override
            public double getValue() {
                return 10.0;
            }
        };

        // Injection manuelle, sans Spring
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);

        // 10.0 * 2 = 20.0 (0.001 = tolérance pour les double)
        Assert.assertEquals(20.0, metier.calcul(), 0.001);
    }
}