
package termproj;

public class Promo {
    int promoID;
    String promoName;
    double promoRate;
    
    //use this constructor if no promo is given
    Promo()
    {
	
    }
    //use this constructor if customer types valid promo
    Promo(String promoName, double promoRate)
    {
	setPromoRate(promoRate);
	setPromoName(promoName);
    }
    Promo(String promoName) {
	setPromoName(promoName);
    }
    
    double getPromoRate()
    {
	return promoRate;
    }
    
    String getPromoName()
    {
	return promoName;
    }
    
    void setPromoRate(double promoRate)
    {
	this.promoRate = promoRate;
    }
    
    void setPromoName(String promoName)
    {
	this.promoName = promoName;
    }
    
}
