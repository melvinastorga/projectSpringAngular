package ucr.ac.cr.api.service;

import ucr.ac.cr.api.entity.LocationNames;

import java.util.List;

public interface ILocationNames {

    public LocationNames getLocationNames(int provinceId, int cantonId, int districtId);
}
