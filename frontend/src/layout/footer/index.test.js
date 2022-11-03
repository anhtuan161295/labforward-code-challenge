import { render, screen } from '@testing-library/react';
import Footer from '.';

test('test footer', () => {
  render(<Footer />);
  const linkElement = screen.getByText(/labforward/i);
  expect(linkElement).toBeInTheDocument();
});
