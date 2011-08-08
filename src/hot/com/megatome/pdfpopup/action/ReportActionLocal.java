package com.megatome.pdfpopup.action;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;

@Local
public interface ReportActionLocal {
    public String getReportURL();
    public void setSelectOneValue(int value);
    public int getSelectOneValue();
    public void setStartDate(Date startDate);
    public Date getStartDate();
    public void setEndDate(Date endDate);
    public Date getEndDate();
    public void doSearch();
    public List<String> getReportData();

    public void remove();
}
