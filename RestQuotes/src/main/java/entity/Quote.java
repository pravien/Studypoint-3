/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Pravien
 */
public class Quote
{
    private String quote;

    public Quote(String quoteText)
    {
        this.quote = quoteText;
    }

    public String getQuoteText()
    {
        return quote;
    }

    public void setQuoteText(String quoteText)
    {
        this.quote = quoteText;
    }

    @Override
    public String toString()
    {
        return "Quote{" + "quote=" + quote + '}';
    }
    
    
    
}
