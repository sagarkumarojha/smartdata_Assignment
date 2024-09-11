package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter( ) {
		// TODO
		return new MemberExporterImpl();
	}

	@Override
	protected MemberImporter getMemberImporter( ) {
		// TODO
		return new MemberImporterImpl();
	}

	@Override
	protected List< Member > getNonDuplicateMembers( List< Member > membersFromFile ) {

		// TODO
		return new ArrayList<>(new HashSet<>(membersFromFile));
	}

	@Override
	protected Map< String, List< Member >> splitMembersByState( List< Member > validMembers ) {
		// TODO
		return validMembers.stream()
                .collect(Collectors.groupingBy(Member::getState));
	}

	public static void main( String[] args ) {
		//TODO
        try {
            File inputFile = new File("Members.txt");
            String outputFilePath = "output"; 
            String outputFileName = "outputFile.csv";

            File outputDirectory = new File(outputFilePath);
            if (!outputDirectory.exists()) {
                outputDirectory.mkdirs();  
            }

            MemberFileConverter converter = new Main();
            converter.convert(inputFile, outputFilePath, outputFileName);

            System.out.println("Conversion completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
	 }

}
