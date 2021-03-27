package edu.ucalgary.ensf409;

public class SupplyChain{

    public void execute(String input){
        input = input.replaceAll("[^0-9a-zA-Z ]", " ");
        //Remove all chars except "0-9","A-Z","a-z";
        String inputArray[] = inputCommand.split("\\s+");

        LinkedList<T> searchResults=Database(inputArray);

        if(searchResults.instanceOf(LinkedList<Chair>)){
            LinkedList<Chair>results=new LinkedList<>();
                results=analyzeData.findCheapestFurniture(searchResults);
        }
        if(searchResults.instanceOf(LinkedList<Desk>)){
            LinkedList<Desk>results=new LinkedList<>();
            results=analyzeData.findCheapestFurniture(searchResults);

        }
        if(searchResults.instanceOf(LinkedList<Lamp>)){
            LinkedList<Lamp>results=new LinkedList<>();
            results=analyzeData.findCheapestFurniture(searchResults);

        }
        if(searchResults.instanceOf(LinkedList<Filing>)){
            LinkedList<Filing>results=new LinkedList<>();
            results=analyzeData.findCheapestFurniture(searchResults);

        }

    }


    public void readInput(String inputFileName) {
        File f = null;
        try {
            f = new File(inputFileName);
            if (!f.exists()) {
                throw new FileNotFoundException("File does not exist");
            } else if (!f.canRead()) {
                throw new IOException("File is not readable");
            }
            FileWriter myWriter = new FileWriter(outputFileName);
            myWriter.close();
            // refresh the old output file. so that every time program runs, it appends new thing to a new output file.
            FileReader a = new FileReader(f);
            BufferedReader sc = new BufferedReader(a);
            String inputCommand = sc.readLine();
            String REGEX="(User request){1}[:]{1}[\\S]+[,]{1}[\\S]+";
            if(inputCommand.matches(REGEX)){
                int i=execute(inputCommand);
            }
            else{
                    writeFile("Input file error.");
                    sc.close();
                    a.close();
                    return;
            }
            sc.close();
            a.close();
        } catch (IOException e) {
            System.out.println("Cannot Read File.");
        }
    }
}