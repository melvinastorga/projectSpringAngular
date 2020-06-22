package ucr.ac.cr.api.service;

import ucr.ac.cr.api.entity.Distric;

import java.util.List;

public interface IDistric {

    public List<Distric> listDistricByCantonProvince(int provinceId, int cantonId);

}
