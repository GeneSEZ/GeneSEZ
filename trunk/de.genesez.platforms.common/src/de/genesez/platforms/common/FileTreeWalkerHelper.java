package de.genesez.platforms.common;

import de.genesez.platforms.common.workflow.feature.FileTreeWalkerFeature;

public class FileTreeWalkerHelper {

	private static FileTreeWalkerFeature currentFileTreeWalker = null;
	private static boolean postFileTreeWalker = false;

	public static void preRegister(Prioritizable feature) {
		if (currentFileTreeWalker == null
				&& feature instanceof FileTreeObserver) {
			throw new IllegalArgumentException(
					"No FileTreeWalkerFeature to register to.");
		} else if (feature instanceof FileTreeWalkerFeature) {
			currentFileTreeWalker = (FileTreeWalkerFeature) feature;
		} else if (feature instanceof FileTreeObserver) {
			currentFileTreeWalker.registerObserver((FileTreeObserver) feature);
		}
	}

	public static void postRegister(Prioritizable feature) {
		if (postFileTreeWalker) {
			preRegister(feature);
		} else if (feature instanceof FileTreeWalkerFeature) {
			postFileTreeWalker = true;
			currentFileTreeWalker = (FileTreeWalkerFeature) feature;
		}
	}

//	public static void sortAndAddFTW(boolean prePrioritySort,
//			List<Prioritizable> featureList) {
//		Collections.sort(featureList, new PriorityComparator(prePrioritySort));
//		List<Integer> ftwPositions = new ArrayList<Integer>();
//		
//		if (prePrioritySort) {
//			for (int i = 0; i < featureList.size(); i++) {
//				Prioritizable feature = featureList.get(i);
//				if (feature.changesPreFileTree()) {
//					ftwPositions.add(i + 1);
//				}
//				if (feature.needsPreWalk()) {
//					ftwPositions.add(i);
//				}
//			}
//			
//		} else {
//			for (int i = 0; i < featureList.size(); i++) {
//				Prioritizable feature = featureList.get(i);
//				if (feature.changesPostFileTree()) {
//					ftwPositions.add(i + 1);
//				}
//				if (feature.needsPostWalk()) {
//					ftwPositions.add(i);
//				}
//			}
//		}
//		
//		for(int i = 0; i < ftwPositions.size()-1; i++){
//			int j = ftwPositions.get(i);
//			if((j+1) == ftwPositions.get(i+1)){
//				ftwPositions.remove(i);
//			}
//		}
//		for(Integer i : ftwPositions){
//			featureList.add(i,new FileTreeWalkerFeature());
//		}
//	}
}
