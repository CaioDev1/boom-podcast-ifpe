package com.boompodcast.reacoes;

import java.util.ArrayList;
import java.util.List;

public class ReactionsUtils {
	public static List<Integer> projectionToList(List<ProjectId> projection) {
		List<Integer> list = new ArrayList<>();
		
		for(ProjectId item : projection) {
			list.add(item.getEpisode_id());
		}
		
		return list;
	}
}
