package cs5200.geppetto.dao.impl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by brian on 11/10/16.
 */
public class MyJdbcDaoSupport extends JdbcDaoSupport {
  @Autowired
  private DataSource dataSource;

  @PostConstruct
  private void initialize() {
    setDataSource(this.dataSource);
  }

  protected String randNumId(int base, int length) {
    String ret = "";
    for (int i = 0; i < length; i++) {
      ret += Math.floor(Math.random() * base);
    }
    return ret;
  }
}
