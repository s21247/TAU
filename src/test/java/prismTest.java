import org.junit.jupiter.api.*;

public class prismTest {
    private final Prism prism = new Prism();

    @BeforeEach
    void init(){
        System.out.println("Run before test");
        prism.setA(0);
        prism.setB(0);
        prism.setC(0);
    }
    @AfterEach
    public void after(){
        prism.setA(0);
        prism.setB(0);
        prism.setC(0);
    }
    @Test
    public void correctVolume(){
        Assertions.assertEquals(6, prism.volume(1,2,3));
    }
    @Test
    public void correctVolumeButOneIsZero(){
        Assertions.assertEquals(0, prism.volume(1,0,3));
    }
    @Test
    public void incorrectVolume(){
        Assertions.assertNotEquals(10, prism.volume(1,2,3));
    }
    @Test
    public void incorrectVolumeThrowsError(){
        Assertions.assertThrows(ArithmeticException.class,() -> prism.volume(1,2,-1));
    }
    @Test
    public void incorrectVolumeThrowsError2(){
        Assertions.assertThrows(ArithmeticException.class,() -> prism.volume(-1,2,1));
    }
    @Test
    public void incorrectVolumeThrowsError3(){
        Assertions.assertThrows(ArithmeticException.class,() -> prism.volume(1,-2,1));
    }
    @Test
    public void correctField(){
        Assertions.assertEquals(22, prism.field(1,2,3));
    }
    @Test
    public void incorrectField(){
        Assertions.assertNotEquals(20, prism.field(1,2,3));
    }

    @Test
    public void incorrectFieldThrowsError(){
        Assertions.assertThrows(ArithmeticException.class,() -> prism.field(-1,2,3));
    }
    @Test
    public void incorrectFieldThrowsError2(){
        Assertions.assertThrows(ArithmeticException.class,() -> prism.field(1,-2,3));
    }
    @Test
    public void incorrectFieldThrowsError3(){
        Assertions.assertThrows(ArithmeticException.class,() -> prism.field(1,2,-3));
    }
}
