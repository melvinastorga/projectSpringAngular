package ucr.ac.cr.api.service;

import ucr.ac.cr.api.entity.Canton;
import ucr.ac.cr.api.entity.Distric;

import java.util.List;

public interface ICanton {

    public List<Canton> listCantonByProvince(int provinceId);

}
