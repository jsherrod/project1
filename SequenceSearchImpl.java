package edu.gcccd.csis.p1;

public class SequenceSearchImpl extends SequenceSearch
{

    public SequenceSearchImpl(final String content, final String start, final String end)
    {
        super(content, start, end);
    }

    @Override
    public String[] getAllTaggedSequences()
    {
        // Declared variables
        int start = 0;
        int end;
        int placeHolder = 0;

        // Declared array
        String[] tags = new String[0];

        // Start returns -1 and exits while loop when no more start tags are found.
        // End returns -1 when no more end tags are found.
        // Method returns the number of tags.
        while (start >= 0)
        {
            start = this.content.indexOf(this.startTag, start);

            if (start >= 0)
            {
                end = this.content.indexOf(this.endTag, startTag.length() + start);
                tags = SequenceSearch.adds(tags, this.content.substring(start + this.startTag.length(), end));
                start = this.endTag.length() + end;

                placeHolder = placeHolder + 1;
            }
        }
        return tags;
    }

    @Override
    public String getLongestTaggedSequence()
    {
        // Declared variables
        String longestTag = null;

        // Declared array
        String[] longTags = getAllTaggedSequences();

        // For loop checks the length of each tag in the tags array and sets the longest tag
        //   to the variable longestTag. Method returns the longestTag value.
        for ( String tag : longTags)
        {
            if ((longestTag == null) || (tag.length() >= longestTag.length()))
            {
                longestTag = tag;
            }
        }
        return longestTag;
    }

    @Override
    public String displayStringArray()
    {
        // Declared variables
        String stringOutput = null;
        String stringHolder;

        // Declared array
        String[] displayString = getAllTaggedSequences();

        // For loop checks and stores the string for each of the tags found in the
        //   getAllTaggedSequences method. Method returns the string.
        for ( String display : displayString)
        {
            stringHolder = display + " : " + display.length() + "\n";

            if (stringOutput == null)
            {
                stringOutput = stringHolder;
            }
            stringOutput = stringOutput + stringHolder;
        }
        return stringOutput;
    }

    @Override
    public String toString()
    {
        // Declared variables
        String content;

        // ToString replace takes the string between the startTag and endTag and sets
        //   content equal to the string. Method returns the string content.
        content = this.content.replace(this.startTag,"");
        content = content.replace(this.endTag,"");

        return content;
    }
}