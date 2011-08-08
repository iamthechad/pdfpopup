package com.megatome.pdfpopup.action;

import org.jboss.seam.ScopeType;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.annotations.*;

import javax.ejb.Stateful;
import javax.ejb.Remove;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Stateful
@Name("reportAction")
@Scope(ScopeType.CONVERSATION)
public class ReportAction implements Serializable, ReportActionLocal{
    private int selectOneValue;
    private Date startDate;
    private Date endDate;

    @Logger
    private Log log;

    @In
    private FacesMessages facesMessages;

    @Out(required = false)
    private List<String> reportData;

    public String getReportURL() {
        return "/pdfpopup/reports/reportDisplay.seam";
    }

    public int getSelectOneValue() {
        return selectOneValue;
    }

    public void setSelectOneValue(int selectOneValue) {
        this.selectOneValue = selectOneValue;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<String> getReportData() {
        return reportData;
    }

    public void doSearch() {
        // This is where the work would actually happen
        reportData = new ArrayList<String>();
        for (int i = 0; i < selectOneValue; i++) {
             reportData.add("Report Row " + (i + 1));
        }
        if (reportData.isEmpty()) {
            facesMessages.add("Report will be empty, not popping up");
        }
    }

    @Destroy
    @Remove
    public void remove() {
    }
}
