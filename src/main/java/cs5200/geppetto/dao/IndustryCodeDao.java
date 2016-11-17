package cs5200.geppetto.dao;

import cs5200.geppetto.model.IndustryCode;

/**
 * Created by brian on 11/17/16.
 */
public interface IndustryCodeDao {
    IndustryCode create(IndustryCode industryCode);
    IndustryCode getByCatCode(String catCode);
    IndustryCode update(IndustryCode industryCode);
    void delete(IndustryCode industryCode);
}
