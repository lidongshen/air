package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IFlightDao;
import entity.Flight;
import service.prototype.IFlightService;

@Service("flightServiceImpl")
public class FlightServiceImpl implements IFlightService{
	@Autowired
	private IFlightDao flightDao;
	
	@Override
	public List<Flight> seachFlightAll() {
		return flightDao.findFlightAll();
	}

	@Override
	public Flight seachFlight(int id) {
		return flightDao.findFlight(id);
	}

	@Override
	public int delFlight(int id) {
		return flightDao.deleteFlight(id);
	}

	@Override
	public int addFlight(Flight flight) {
		return flightDao.insertFlight(flight);
	}

	@Override
	public int modify(Flight flight) {
		return flightDao.upDateFlight(flight);
	}

	@Override
	public List<Flight> flightPage(int pageNo, int pageSize) {
		return flightDao.findFlightPager((pageNo-1)*pageSize, pageSize);
	}

	@Override
	public int totalItems() {
		return flightDao.totalNum();
	}

}
